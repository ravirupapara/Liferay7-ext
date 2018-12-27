# Liferay7-ext
Ext plugin development for the liferay 7.1+ with overriding userLocalService

# Installation
 - Start Liferay 7.1+
 - From build, deploy ext-demo-ext-7.0.0.1.war and com.demo-1.0.0.jar 
 - After deploying the ext you need to restart the portal to have effect of changes.
 - Add User module on some page with adding user with email ravi@liferay.com
 - From control panel enable log level to info for the com.liferay.portal.service.impl.UserLocalServiceImpl to know your custom log in the usermodule. [Checkout to persist log level](https://dev.liferay.com/en/discover/deployment/-/knowledge_base/6-2/liferays-logging-system)
 - Refresh the page where you added the user-module. you will find your custom log for the delete user method. 

You can override any method of the any service you want but you have to copy whole class and add your custom business login in perticular method.

# Note:
 - Once ext deployed it is not going to undeploy or update by any case. You need to start work with new porta