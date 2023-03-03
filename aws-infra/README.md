## AWS CDK

### Commandes
`cdk init app --language java`
`cdk bootstrap`
`cdk deploy`

### IAM
Créer Utilisateur : `cdk`
Créer Groupe :  `cdk`

**Droits**

- IAMFullAccess
Provides full access to IAM via the AWS Management Console.

- AmazonEC2ContainerRegistryFullAccess
Provides administrative access to Amazon ECR resources

- AmazonS3FullAccess
Provides full access to all buckets via the AWS Management Console.

- AmazonAPIGatewayAdministrator
Provides full access to create/edit/delete APIs in Amazon API Gateway via the AWS Management Console.

- AmazonSSMFullAccess
Provides full access to Amazon SSM.

- AWSCloudFormationFullAccess
Provides full access to AWS CloudFormation.

- AWSLambda_FullAccess
Grants full access to AWS Lambda service