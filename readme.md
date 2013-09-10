#Screen Staus Plugin
This plug-in provides information about the screen of the device (the android phone) mainly if the screen is turned on or off.

Plugin ID: org.ambientdynamix.contextplugins.screenstatus

###Supported Context Type
<table>
    <tr>
        <td>Context Types</td><td>Privacy Risk Level</td><td>Data Types</td><td>Description</td>
    </tr>
    <tr>
        <td>org.ambientdynamix.contextplugins.context.info.device.screenstatus</td><td>HIGH</td><td>ScreenStatusContextInfo</td><td>Information on the screen status</td>
    </tr>
</table>

###Use
The plugin sends status updates whenever the status of the screen changes or whenever rewuested.

###Native App Usage
Add context support as follows:

```Java
dynamix.addContextSupport(dynamixCallback, "org.ambientdynamix.contextplugins.context.info.device.screenstatus");
```
  
### Plug-in Data-type JAR

[Download](https://github.com/TVLuke/DynamixScreenStatusPlugin/raw/master/dist/org.ambientdynamix.contextplugins.screenstatus_datatypes_1.0.0.jar "Screen Status jar")

### Copyright

#### Kudos
Plugin for the Ambient Dynamix Framework. You can find Ambient Dynamix at http://ambientdynamix.org

Using the Dynamix Plugin Builder: https://bitbucket.org/ambientlabs/dynamix-plug-in-builder

Using the Dynamix Context Library

#### Copyright Notice

Copyright (C) Institute of Telematics, Lukas Ruge

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

[http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.