package com.example.AWSECS.Controller;




import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.codedeploy.model.ECSService;
import com.amazonaws.services.ec2.AmazonEC2;
import com.amazonaws.services.ec2.AmazonEC2ClientBuilder;
import com.amazonaws.services.ec2.model.StartInstancesRequest;
import com.amazonaws.services.ec2instanceconnect.AWSEC2InstanceConnectClient;
import com.amazonaws.services.ecs.AmazonECS;
import com.amazonaws.services.ec2.model.DescribeInstancesRequest;

import com.amazonaws.services.ecs.AmazonECSClientBuilder;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin
@RequestMapping("/aws")
public class controller {

    @GetMapping("/chaos")
    public void chaos() {

        try {



            AmazonEC2 amazonEC2 = AmazonEC2ClientBuilder.standard().withRegion(Regions.US_EAST_1)
                    .build();
            String instanceId="i-01617add322847a93";
            DescribeInstancesRequest describeInstancesRequest =new DescribeInstancesRequest().withInstanceIds(instanceId);

            amazonEC2.describeInstances(describeInstancesRequest);
            System.out.println(amazonEC2.describeInstances(describeInstancesRequest));
            System.out.println("Connected");
            
        }catch (Exception e)
        {
            System.out.println(e);
        }

    }
}
