# Zookeeper-Basics
Repository containing Java code to perform basic operations on Zookeeper

Download zookeeper and use the following command to start zookeeper on your local machine:-
For Windows:- zookeeper-server-start.bat <PATH_TO_ZOOKEEPER_CONFIG_FOLDER>\zookeeper.properties
For Linux:- ./zookeeper-server-start.sh <PATH_TO_ZOOKEEPER_CONFIG_FOLDER>\zookeeper.properties

By default Zookeeper will run on 2181 port. You can change the port in the properties file.

This is a maven project. To import the zookeeper dependency on your local machine, update the project using command "mvn update" or if the projected is imported in Eclipse IDE, right click on the project -> Select Maven -> Update Project. This will download the dependencies required to connect and interact with Zookeeper.

There are 5 files in the repo.
1. ZKConnect.java -> File containing the code to establish connection to Zookeeper.
2. ZKTestConnection.java -> File containing the test code to check if the connection establishment was successful or not. By default it tries to connect to zookeeper running on local mahine ("localhost:2181")
3. ZKZnodeACL.java -> This file contains the code to get information about a particular zookeeper ZNode.
4. ZkZNodeDigestSchemeACL.java -> Contains the code to add a layer of authorization while accessing a particular zookeeper Znode. To set digest authentication, user can open the Zookeeper shell and run the command:- "addauth digest <username>:<password>"
5. ZkZnodeFunctions.java -> This contains the basic CRUD operations which can be performed on a zookeeper znode. It contains the logic to create, update, delete or read a Znode.
