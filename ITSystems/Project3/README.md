## Part 2
1. Project Description
   
   The goal of this project is to create a load balancer instance using HAProxy to distribute traffic to 3 web server instances running apache2.  The first step of this process is to upload the CloudFormation template provided ([HOLLACK-cf.yml](https://github.com/WSU-kduncan/ceg3120-Cacanuck/blob/main/Project3/HOLLACK-cf.yml)) to AWS to create a stack.  This template will create 1 proxy instance, 3 web server instances, 1 private subnet, 1 public subnet, a public and private route table, a VPC, an Internet Gateway, a NAT Gateway, a security group ruleset for SSH and HTTP, an elastic IP for the proxy instance, and a basic Network ACL ruleset.
   
   <img width="690" alt="Screen Shot 2024-11-04 at 9 34 53 PM" src="https://github.com/user-attachments/assets/fe1280fe-0a7f-4e11-9952-783946f46728">

   
2. SSH Information

   To ssh between different instances on the VPC, first you need to ssh to the proxy instance.  To do this, you type in `ssh -i <keyName.pem> ubuntu@<ipaddress>`.  Once in the proxy instance, navigate to the `.ssh` folder and create a config file.  In the config file, the format is as follows:
   ```
   Host <name to type in ssh>
      HostName <IP Address>
      User <name of user>
      IdentityFile <path/to/key>
      Port 22
   ```
   Ensure to do this for each of the web servers that need to be accessed for ssh.  You also need to ensure to copy the key file to every instance, and the make sure to do `chmod 700 <key>` so that only the owner of the file has permission to use it. An example of one of the config files in one of the web server instances is as follows:
   ```
   Host proxy
        Hostname 44.216.244.242
        User ubuntu
        IdentityFile /home/ubuntu/.ssh/HOLLACK-key.pem
        Port 22

   Host webserv2
        Hostname 172.18.1.12
        User ubuntu
        IdentityFile /home/ubuntu/.ssh/HOLLACK-key.pem
        Port 22

   Host webserv3
        Hostname 172.18.1.13
        User ubuntu
        IdentityFile /home/ubuntu/.ssh/HOLLACK-key.pem
        Port 22
   ```

3. Setting up HAProxy

   To set up HAProxy, first you need to configure the config file found in `/etc/haproxy/haproxy.cfg`. The defaults and global sections can be left alone, but you need to configure the frontend and backend blocks.  For frontend, the block needs to have a name to be referred to, as well as binding the haproxy service to listen for all traffic on port 80.  You also need to specify the default backend to be the created backend block, so that all traffic that the frontend block serves will be routed to the backend block.  In the backend block, it also needs a name to be referred to.  It also needs a load balance algorithm specified, and for the different servers to be identified by name and private IP, and to tell those servers to listen on port 80 for traffic coming from the frontend.  The global block gives settings for HAProxy as a service, and the default block sets default rules and commands for different things, such as how long to wait beofre a timeout is sent, or where to pull error pages from.  After the config file is changed, you need to do `sudo systemctl restart haproxy` in order to restart haproxy and ensure that the changes made to the config file are in effect.

4. Setting up Host instances

   Once on a host instance, to replace the default website with a website that you use, you need to navigate to `var/www/html/index.html` and change the index file to be what what you want it to be.  The apache2 config file is located in `/etc/apache2`, and if any changes were made to the config files here, then `sudo systemctl restart apache2` needs to be run for those changes to take effect.  If there were changes made to the web content after the apache2 service was already running, then `sudo systemctl reload apache2` would need to be run to update the web content changes.

5. Load Balanced

   You can tell that the load balancer is working because the header at the top of the page is changing based on what server is hsoting the page.
   
   <img width="1440" alt="Screen Shot 2024-11-04 at 5 51 29 PM" src="https://github.com/user-attachments/assets/288c57f1-6c26-4559-b4f8-30f79bf7dd15">
   <img width="1440" alt="Screen Shot 2024-11-04 at 5 51 48 PM" src="https://github.com/user-attachments/assets/59a2e01c-3c84-4521-b2c4-4ab7586bde3a">

To check the logs of the servers, the command is `tail -f /var/log/haproxy.log`.  This will show the timestamp the log was created, from where, and what was being queried.

<img width="648" alt="Screen Shot 2024-11-04 at 6 00 43 PM" src="https://github.com/user-attachments/assets/aaecdfc6-1ea4-40f7-b4ae-8e9319b77332">

