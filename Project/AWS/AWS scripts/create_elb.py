#script to create an electric load balancer and connect 2 instance to it

import boto.ec2
import boto.ec2.networkinterface
import boto.ec2.elb
from boto.ec2.elb import HealthCheck
from boto.ec2.elb import ELBConnection
from boto.route53.connection import Route53Connection
from boto.route53.record import ResourceRecordSets
import logging
#Helper functions
def connect_to_region(AWS_ACCESS_KEY,AWS_SECRET_ACCESS_KEY,REGION):
    ec2 = boto.ec2.connect_to_region(REGION, aws_access_key_id=AWS_ACCESS_KEY,
                                     aws_secret_access_key=AWS_SECRET_ACCESS_KEY)
    return ec2


def create_elb(conn, zones, ports, name):
    lb = conn.create_load_balancer(name, zones, ports)
    hc = HealthCheck(
        interval=20,
        healthy_threshold=3,
        unhealthy_threshold=5,
        target='HTTP:8080/health'
    )
    lb.configure_health_check(hc)
    return lb


def add_instances_elb(lb, instances_ids):
    lb.register_instances(instances_ids)


AWS_ACCESS_KEY =""
AWS_SECRET_ACCESS_KEY = ""
REGION = "us-east-1"
vpc_id = ""
vpc_name = "TS Sandbox VPC"
subnet_id = "subnet-ccd47eba"
elb_name = "purpleElb"
hostedZoneId = "Z1X5WYYAS0Z9FM"
name_dns = "elbpurple.lunaprimero.com"
print "Welcome!"
print "Connecting to region " + REGION + " on AWS"


#Program starts
con_elb = ELBConnection(AWS_ACCESS_KEY,AWS_SECRET_ACCESS_KEY)
print boto.ec2.elb.regions()
ec2 = connect_to_region(AWS_ACCESS_KEY,AWS_SECRET_ACCESS_KEY,REGION='ec2.us-east-1.amazonaws.com')

lb = con_elb.create_load_balancer(name=elb_name,zones=None,listeners=[(80, 80, 'http'), (443, 443, 'tcp')], subnets=subnet_id, security_groups="sg-b2cc14c9")
add_instances_elb(lb,["i-788e3cfe","i-57e62012"])

print "The elb name is " + lb.dns_name

con_r53 = Route53Connection(AWS_ACCESS_KEY,AWS_SECRET_ACCESS_KEY)
change_set = ResourceRecordSets(con_r53,hostedZoneId)

changes = change_set.add_change("CREATE", name_dns,"CNAME")
changes.add_value(lb.dns_name)
try:
    change_set.commit()
except Exception, e:
    logging.error(e)
