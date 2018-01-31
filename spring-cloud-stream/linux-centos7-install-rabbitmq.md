# linux centos7 install rabbitmq
> 最新更新参考有道分享：http://note.youdao.com/noteshare?id=0a2234bf32d7486919fa20666d37b762

## 1.install EPEL yum

```
wget http://dl.fedoraproject.org/pub/epel/7/x86_64/Packages/e/epel-release-7-11.noarch.rpm  
rpm -ivh epel-release-7-11.noarch.rpm
```

## 2. Install Erlang


```Shell
yum install erlang.x86_64
```

## 3. download rabbitmq
chose your download version from download page: https://www.rabbitmq.com/download.html

```Shell
wget http://www.rabbitmq.com/releases/rabbitmq-server/v3.6.6/rabbitmq-server-3.6.6-1.el7.noarch.rpm

yum install rabbitmq-server-3.6.6-1.el7.noarch.rpm 

```

## 4. Managing the Broker

To stop the server or check its status, etc., you can invoke rabbitmqctl (as an administrator). It should be available on the path. All rabbitmqctl commands will report the node absence if no broker is running.

```Shell
# enable start on boot
systemctl enable rabbitmq-server
systemctl status rabbitmq-server

# start
systemctl start rabbitmq-server

rabbitmqctl stop 
rabbitmqctl status
```

## 3. rabbitmq user

Default user access

The broker creates a user guest with password guest.Unconfigured clients will in general use these credentials. By default, these credentials can only be used when connecting to the broker as localhost so you will need to take action before connecting from any other machine.

```
# add vhost
sudo rabbitmqctl add_vhost SOP

# Creating user "footprint" ...
sudo rabbitmqctl add_user footprint footprint

# Setting permissions for user "footprint" in vhost "SOP" ...
sudo rabbitmqctl  set_permissions -p SOP footprint "^footprint.*" ".*" ".*"

```

## 5. Logging
Output from the server is sent to a RABBITMQ_NODENAME.log file in the RABBITMQ_LOG_BASE directory. Additional log data is written to RABBITMQ_NODENAME-sasl.log.

The broker always appends to the log files, so a complete log history is retained.

You can use the logrotate program to do all necessary rotation and compression, and you can change it. By default, this script runs weekly on files located in default /var/log/rabbitmq directory. See /etc/logrotate.d/rabbitmq-server to configure logrotate.

## 6. enable rabbitmq management plugin

```
rabbitmq-plugins enable rabbitmq_management
```
If you wish to build the plugin from source, it can be built like any other. See the plugin development page for more information.

The web UI is located at: `http://server-name:15672/`

The HTTP API and its documentation are both located at: `http://server-name:15672/api/` (or view our latest HTTP API documentation here).

## 7. Give user management permisstion:

The management plugin makes use of tags called "management", "policymaker", "monitoring" and "administrator".

```
rabbitmqctl set_user_tags sop-sms-service administrator
```


## 8. use management command line:

Download rabbitmqadmin from `http://server-name:15672/cli/`
```
rabbitmqadmin get queue=pre-login_sms-verification requeue=false
```


## REFERENCE

https://www.rabbitmq.com/install-rpm.html