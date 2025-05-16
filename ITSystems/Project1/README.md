## Part 1

1. VPC - 
  This resource creates an instance of a blank VPC.  The resource asks for a name for the VPC, and IPv4 CIDR Block, and has the option for an IPv6 CIDR Block.
<img width="1435" alt="VPCScreenshot" src="https://github.com/user-attachments/assets/c40a0b31-faca-463c-955a-d1b537516026">

2. Subnet - 
  This resource allows the user to create a subnet.  The user can create a name for the subnet, as well as attach it to a VPC.  The user also needs to specify a CIDR Block for the subnet, which needs to be less than the CIDR Block of the VPC.
<img width="1440" alt="SubnetScreenshot" src="https://github.com/user-attachments/assets/d8eb4d6c-5086-4f5f-a068-06e1f841d342">

3. Internet Gateway - 
  This resource allows the user to create an internet geteway for the VPC.  After creating a VPC, the user is then prompted to attach the gateway to the VPC.
<img width="1435" alt="GatewayScreenshot" src="https://github.com/user-attachments/assets/20fb1ce9-ba38-468a-8569-624e206941b2">

4. Route Table - 
  This resource allows the user to create a Route Table.  It prompts the user for a name for the rougt table, as well as a VPC to attach it to.  In the details of the Route Table, the user can also assosciate it with a specific subnet on the VPC.  The user can also add a routing table rule to allow the VPC to communicate with other systems.
<img width="1436" alt="RouteTableScreenshot" src="https://github.com/user-attachments/assets/d62e94c5-87c2-4fc9-b8d4-1475081495bc">

5. Security Group - 
  This resource allows the user to create a security group and attach it to a VPC.  It asks the user for the name of the security group, what VPC to attavh it to, and allows the user to create inbound and outbound rules for the security group.
<img width="1440" alt="Screen Shot 2024-09-27 at 8 55 09 AM" src="https://github.com/user-attachments/assets/ca22719f-90f0-4141-8bca-976884648021">


6. Network ACL - 
  This resource allows the user to create a Network ACL by giving it a name and attaching it to a VPC. After the creation, the user must associate the ACL with a subnet.  The user can then go to edit the inbound and outbound rules, specifiying what ports and IPs can have inbound and outbound access to the system.
<img width="1440" alt="Screen Shot 2024-09-27 at 9 38 09 AM" src="https://github.com/user-attachments/assets/c4a9756a-7b60-4880-aa90-c2c112184aff">

7. Key Pair - 
  this resource allows the user to create a key pair for accessing their VPC/instance. The user is given the option to name the key pair, as well as to choose between RSA or ed25519 encryption.  The user can also choose if they cant the private key to end in .pem or .ppk. The public key of the pair is stored on Amazon's system, and the private key is downloaded right away.
<img width="1440" alt="KeyPairScreenshot" src="https://github.com/user-attachments/assets/1014dc0c-ca2a-47cc-bd0e-611f0a29416c">

8. Elastic IP Address - 
  This resource allows the user to create an Elastic IP.  An elastic IP is an IP address that does not change every time the instance in booted up, but styas the same.  A public IP address, in this case, is one that changes every time the system is booted up.  The resource will laos allow the user to associate the IP with an instance.
<img width="1436" alt="ElasticIPScreenshot" src="https://github.com/user-attachments/assets/4e184de6-d49a-4f18-9a35-f7039e3a4742">


## Part 2

1.
  An instance is a virtual server, and can be launched/created by clicking the EC2 button and then clicking Launch Instance. The AMI I have selected is Ubuntu, and the AMI ID is: ami-0e86e20dae9224db8. The default username of the instance is ubuntu. The keypair chosen is HOLLACK-key, which was generated in Part 1 of the project. A keypair needs to be chosen in order to gain initial access to the instance. In the network settings tab, click on edit and ensure that the correct VPC is selected. The user also has the option to select or create a subnet and security group, so in this case the selected subnet is HOLLACK-subnet and HOLLACK-sg. Finally, make sure to tag the instance with a name so that it is easily understandable of what the instance is.
  
2.
  To connect the elastic IP created in Part 1, click on elastic IPs on the sidebar and click actions. In the actions menu, click associate the created elastic IP with the newly created instance. Then Choose which instance you want to IP to be associated with, and choose a private IP available on the instance for it to use.
  
3.
<img width="1437" alt="InstanceScreenshot" src="https://github.com/user-attachments/assets/168a6a22-7dc7-469a-bdba-1f97d23f2dbe">

## Part 3

1. To SSH into the instance, type in the following command to the command line: `ssh -i HOLLACK-key.pem ubuntu@54.196.87.140` . This command tells the system to use the ssh protocol to connect, using the private key HOLLACK-key.pem, to the user ubuntu at the IP address 54.196.87.140. This can only be done after downloading the private key from the key pairs, and saving it in a place where it can be easily accessed.
2. To change the hostname, first copt the `/etc/hosts` file into a new file called `/etc/hosts.old`. Do this with the `hostname` file as well. This will preserve the previous version of the file. Then type in `hostname` to see what the current hostname is. In the `hostname` file, chagne the hostname to HOLLACK-AMI, and in the `hosts` file change the name next to the IP number at the top to HOLLACK-AMI as well.
3. <img width="656" alt="Screen Shot 2024-09-27 at 4 12 04 PM" src="https://github.com/user-attachments/assets/74903002-570a-46e1-9c76-27a762fd7b6f">
4. <img width="645" alt="Screen Shot 2024-09-27 at 4 17 39 PM" src="https://github.com/user-attachments/assets/c762fdc4-eee6-45d3-8fc3-560ffca982c7">
