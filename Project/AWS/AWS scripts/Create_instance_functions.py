import boto.ec2
import boto.ec2.networkinterface
import os
import time
from boto.vpc import VPCConnection
AWS_ACCESS_KEY =""
AWS_SECRET_ACCESS_KEY = ""

def connect_to_region(AWS_ACCESS_KEY,AWS_SECRET_ACCESS_KEY,REGION):
    ec2 = boto.ec2.connect_to_region(REGION, aws_access_key_id=AWS_ACCESS_KEY,
                                     aws_secret_access_key=AWS_SECRET_ACCESS_KEY)
    return ec2


def get_security_groups(ec2):
    sg=ec2.get_all_security_groups(filters={"tag:SecurityGroup": "Purple"})
    print sg
    sg_list = str(sg).split(",")
    return sg_list


def authorize_http(group):

    if group.authorize('tcp', 80, 80, '0.0.0.0/0'):
        print "HHTP authorized for group " + str(group)
    else:
        print "Error authorizing HTTP for group " + str(group)
    return


def create_security_group(ec2,name,description,vpc_id):
    group = ""
    c = VPCConnection(AWS_ACCESS_KEY, AWS_SECRET_ACCESS_KEY)
    vpc_list = c.get_all_vpcs(filters={"tag:Name": name})
    if len(vpc_list) > 0:
        print len(vpc_list)
        group = ec2.create_security_group(name,description,vpc_id)
    else:
        print "The security group "+ name + " already exists"
    return group


def group_permission(group,protocol,fromPort,toPort,address) :
    group.authorize(protocol,fromPort,toPort,address)
    return

#function to create an instance


def create_instance (ec2,ami_image_id, key_name, instance_type,security_group,subnet_id):
    id = ec2.run_instances(ami_image_id,key_name=key_name,instance_type=instance_type,security_group_ids =[security_group],subnet_id=subnet_id)
    return id


def getIpAddressImport():
    import socket
    ip_address = socket.gethostbyname(socket.gethostname())
    return ip_address


def create_key_pair(ec2, name):
    try:
        keys =ec2.get_all_key_pairs(keynames=[name])
    except ec2.ResponseError, e:
        if e.code == 'InvalidKeyPair.NotFound':
            print "Creating keypair " + name
            key = ec2.create_key_pair(name)
            key.save(os.path.dirname(os.path.realpath(__file__)))
            return key
        else:
            print "Key " + name + " already exists !"
            return


def wait_for_instance(instance):
    while instance.state == "pending":
        print instance, instance.state
        time.sleep(5)
        instance.update()


def create_instance_tags(instance_id, tags,con):
    con.create_tags([instance_id], {"Name": tags})


def create_network_interface(ec2,subnet_id,groups):
    interface = boto.ec2.networkinterface.NetworkInterfaceSpecification(subnet_id =subnet_id,groups = groups, associate_public_ip_address = True)
    interfaces = boto.ec2.networkinterface.NetworkInterfaceCollection(interface)
    return interfaces