#Script to create and instance in AWS


#Import all the helper functions from the Create_instances_functions file

from Create_instance_functions import *
import boto
import boto.ec2.networkinterface
AWS_ACCESS_KEY =""
AWS_SECRET_ACCESS_KEY = ""
REGION = "us-east-1"
vpc_id = ""
vpc_name = "TS Sandbox VPC"
subnet_id = ""
print "Welcome!"
print "Connecting to region " + REGION + " on AWS"


ec2 = connect_to_region(AWS_ACCESS_KEY,AWS_SECRET_ACCESS_KEY,REGION)


c = VPCConnection(AWS_ACCESS_KEY,AWS_SECRET_ACCESS_KEY)
datacenters = c.get_all_vpcs(filters={"tag:Name":vpc_name})
for i in datacenters:
    vpc_id =i.__dict__['id']
print "The id for the vpc " + vpc_name + " is " + vpc_id
subnets =c.get_all_subnets(filters={"tag:Name":"Public Subnet 1 "})
if len(subnets)>0:
    subnet_id = subnets[0].__dict__['id']
    print "The id for the subnet" + " is " + subnet_id

ami_image_id = "ami-f5f41398"
key_name = "Fidele_test"
instance_type = "t2.micro"
security_group = "Purple"
security_group_description = "Purple Test"
security_group_id = "sg-b2cc14c9"
instance_name = "TestWebServer"


create_security_group(ec2,security_group,security_group_description,vpc_id=vpc_id)
print "Security group"

#ip_address=getIpAddressImport()
#authorize_http(sg)
#group_permission(sg,'tcp',22,22,"192.168.56.1/32")

key = create_key_pair(ec2,key_name)
print key
print ec2.get_all_key_pairs(keynames=[key_name])[0].__dict__['fingerprint']


print "Creating instance with the following"
print "ami_image_id: " + ami_image_id
print "key_name: "+ key_name
print "instance_type: " + instance_type
print "security_group_id: " + security_group_id
print "subnet_id: " + subnet_id




#interface = ec2.networkinterface.NetworkInterfaceSpecification(subnet_id=subnet_id,groups=security_group_id, associate_public_ip_address=True,)

reservation = create_instance(ec2,ami_image_id, key_name, instance_type,security_group_id,subnet_id)
instance = reservation.instances[0]
instance.update()

wait_for_instance(instance)
print "The instance id is "
instance_ids = str.split(str(reservation.__dict__['instances'][0]), ":")
instance_id = instance_ids[1]

c.create_tags([instance_ids[1]], {"Name": instance_name})
for i in ec2.get_all_addresses():
    if not i.instance_id :
        print "Found an empty address !"
        print i.__dict__
        ec2.associate_address(instance_id= instance_id,public_ip=i.public_ip)
        break
#print "IP is " + interface.private_ip_address
'''
create_instance_tags(instance_id,instance_name,c)
try:
    cni = con.create_network_interface(subnet_id=subnet_id,description="Ip for webservertest")
except cni.ResponseError, e:
    for a in addrs:
        if a.network_interface_id == "None":
            ai = a.allocation_id
            print ai
            eip = con.allocate_address(domain=vpc_id)
            ee = con.associate_address(allocation_id=eip.allocation_id, instance_id=instance_id,
                                       network_interface_id=cni.id)
        break
        print a.__dict__
        #return key
    else:
        print "No more IP addresses !"
#eip = con.allocate_address(domain= vpc_id)
#ee = con.associate_address(allocation_id=eip.allocation_id,instance_id=instance_id,network_interface_id=cni.id)
'''
#print ("The id of your new instance is " + instance_id)
