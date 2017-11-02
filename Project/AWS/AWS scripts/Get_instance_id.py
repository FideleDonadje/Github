import boto.ec2
from pprint import pprint
ids = ""
status = ""
tag = "Purple"
AWS_SECRET_ACCESS_KEY = ""
AWS_ACCESS_KEY =''
ec2 = boto.ec2.connect_to_region("us-east-1", aws_access_key_id=AWS_ACCESS_KEY,aws_secret_access_key=AWS_SECRET_ACCESS_KEY)

#Use the filter by name to get the correct instance
reservations = ec2.get_all_instances(filters={"tag:Name":tag})

instances = [i for r in reservations for i in r.instances]
for i in instances:
    #Display all the information of an instance
    #pprint(i.__dict__)
    instance_id = i.__dict__['id']
    state = str(i.__dict__['_state'])
    #cast the instance id to a string
    ids = str(instance_id)
print "The status of the instance " + tag + " is " + state

'''
if ec2.start_instances(instance_ids=ids):
    print "Instance " + instance_id + " started !"
status = ec2.get_all_instance_status(instance_ids=ids)
print  type(status)
if ec2.stop_instances(instance_ids=ids):
    print "Instance " + instance_id + " stopped !"
status = ec2.get_all_instance_status(instance_ids=ids)
print status
'''