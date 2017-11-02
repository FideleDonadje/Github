import boto

AWS_SECRET_ACCESS_KEY = ""
AWS_ACCESS_KEY =''
ec2 = boto.ec2.connect_to_region("us-east-1", aws_access_key_id=AWS_ACCESS_KEY,aws_secret_access_key=AWS_SECRET_ACCESS_KEY)

