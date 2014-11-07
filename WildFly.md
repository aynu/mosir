# WildFly

http://wildfly.org/

## はじめに

### ヘルプ `$ mvn wildfly:help`
    
## Mavenゴール

### リソース追加 `$ mvn wildfly:add-resource`

Adds a resource If force is set to false and the resource has already been
deployed to the server, an error will occur and the operation will fail. Note:
this currently only works with adding resources to subsystems when your server
is running in domain mode.

### デプロイ `$ mvn wildfly:deploy`

Deploys the application to the WildFly Application Server. If force is set to
true, the server is queried to see if the application already exists. If the
application already exists, the application is redeployed instead of deployed.
If the application does not exist the application is deployed as normal. If
force is set to false and the application has already been deployed to the
server, an error will occur and the deployment will fail.

### 任意デプロイ `$ mvn wildfly:deploy-artifact`

Deploys an arbitrary artifact to the WildFly application server

### デプロイのみ `$ mvn wildfly:deploy-only`

Deploys only the application to the WildFly Application Server without first
invoking the the execution of the lifecycle phase 'package' prior to executing
itself. If force is set to true, the server is queried to see if the
application already exists. If the application already exists, the application
is redeployed instead of deployed. If the application does not exist the
application is deployed as normal. If force is set to false and the
application has already been deployed to the server, an error will occur and
the deployment will fail.

### コマンド実行 `$ mvn wildfly:execute-commands`

Execute commands to the running WildFly Application Server. Commands should be
formatted in the same manor CLI commands are formatted. Executing commands in
a batch will rollback all changes if one command fails.
 <execute-commands>
 <batch>true</batch>
 <commands>

<command>/subsystem=logging/console=CONSOLE:write-attribute(name=level,value=DEBUG)</command>
 </commands>
 </execute-commands>

### ヘルプ `$ mvn wildfly:help`

Display help information on wildfly-maven-plugin.
Call mvn wildfly:help -Ddetail=true -Dgoal=<goal-name> to display parameter
details.

### 再デプロイ `$ mvn wildfly:redeploy`

Redeploys the application to the WildFly Application Server.

### 再デプロイ のみ `$ mvn wildfly:redeploy-only`

Redeploys only the application to the WildFly Application Server without first
invoking the the execution of the lifecycle phase 'package' prior to executing
itself.

### サーバ実行 `$ mvn wildfly:run`

Starts a standalone instance of WildFly and deploys the application to the
server. This goal will block until cancelled or a shutdown is invoked from a
management client.

### サーバ停止 `$ mvn wildfly:shutdown`

Shuts down a running WildFly Application Server. Can also be used to issue a
reload instead of a full shutdown.

### サーバ開始 `$ mvn wildfly:start`

Starts a standalone instance of WildFly Application Server. The purpose of
this goal is to start a WildFly Application Server for testing during the
maven lifecycle. This can start a remote server, but the server will be
shutdown when the maven process ends.

### アンデプロイ `$ mvn wildfly:undeploy`

Undeploys the application to the WildFly Application Server.

### 任意アンデプロイ `$ mvn wildfly:undeploy-artifact`

Undeploys (removes) an arbitrary artifact to the WildFly application server
