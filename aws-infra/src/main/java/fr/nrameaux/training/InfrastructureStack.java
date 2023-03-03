package fr.nrameaux.training;

import software.amazon.awscdk.CfnOutput;
import software.amazon.awscdk.Stack;
import software.amazon.awscdk.StackProps;
import software.amazon.awscdk.services.apigateway.LambdaRestApi;
import software.amazon.awscdk.services.lambda.Code;
import software.amazon.awscdk.services.lambda.Function;
import software.amazon.awscdk.services.lambda.Runtime;
import software.constructs.Construct;

public class InfrastructureStack extends Stack {

    public InfrastructureStack(final Construct scope, final String id) {
        this(scope, id, null);
    }

    public InfrastructureStack(final Construct scope, final String id, final StackProps props) {
        super(scope, id, props);

        // Création de la fonction Lambda
        Function lambdaFunction = Function.Builder.create(this, "driversLambdaFonction")
                .runtime(Runtime.JAVA_11)
                .handler("fr.nrameaux.training.app.handler.DriversHandler::handleRequest")
                .code(Code.fromAsset("../app/target/lambda-graalvm-rt-1.0-SNAPSHOT.jar"))
                .build();

        // Crée une API Gateway associée à la fonction Lambda
        LambdaRestApi lambdaRestApi = LambdaRestApi.Builder.create(this, "driversAPI")
                .handler(lambdaFunction)
                .build();

        // Affichage de l'URL de l'API Gateway
        CfnOutput.Builder.create(this, "DriversApiUrl")
                .exportName("DriversApiUrl")
                .value(lambdaRestApi.getUrl())
                .build();
    }
}