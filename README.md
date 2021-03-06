#NetworkUtils
An Android Library for common network operations with a fluent and easy to use API.

Simple, fast and thread safe library that extends the existing Android Network-API and adds more features to it. 

---

##Table of Contents
1. [Sample Application](https://github.com/PDDStudio/NetworkUtils#sample-application)
2. [Gradle Dependency](https://github.com/PDDStudio/NetworkUtils#gradle-dependency)
	1. [Repository](https://github.com/PDDStudio/NetworkUtils#repository)
	2. [Dependency](https://github.com/PDDStudio/NetworkUtils#dependency)
3. [Library Features Overview](https://github.com/PDDStudio/NetworkUtils#library-features-overview)
	1. [General Overview](https://github.com/PDDStudio/NetworkUtils#general-overview)
	2. [NetworkUtils Javadoc](https://github.com/PDDStudio/NetworkUtils#networkutils-javadoc)
4. [Installation](https://github.com/PDDStudio/NetworkUtils#installation)
5. [Synchroneous Calls](https://github.com/PDDStudio/NetworkUtils#synchronous-operations)
6. [Asynchroneous Calls](https://github.com/PDDStudio/NetworkUtils#asynchronous-operations)
7. [ToDo List](https://github.com/PDDStudio/NetworkUtils#todo-list)
8. [About & Contact](https://github.com/PDDStudio/NetworkUtils#about--contact)
9. [License](https://github.com/PDDStudio/NetworkUtils#license)

---

## Sample Application

Please check the sample repository for a live-preview on how to use this library (of course this is only one of a few possibillities).
You can download [the sample apk directly from this repository](https://github.com/PDDStudio/NetworkUtils/raw/master/networking-demo-sample.apk)

## Gradle Dependency
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg?style=flat-square)](https://www.apache.org/licenses/LICENSE-2.0.html)

[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.pddstudio/networkutils/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.pddstudio/networkutils)

[![Minimum SDK](https://img.shields.io/badge/Min.%20SDK-16-blue.svg)](https://github.com/PDDStudio/NetworkUtils)

[![GitHub issues](https://img.shields.io/github/issues/PDDStudio/NetworkUtils.svg)](https://github.com/PDDStudio/NetworkUtils/issues)

#### Repository
NetworkUtils is a Free and OpenSource Android Library which can be found on [GitHub](https://github.com/PDDStudio/NetworkUtils).

The binary packages of this library are published on [Maven Central]() and can be included into your project by only adding the library as dependency to your project.

*Please make sure you're always using the latest version of NetworkUtils*

#### Dependency

**Note:** NetworkUtils uses [Semantic Versioning](http://semver.org/) for it's release/snapshot version number naming.

To use this library, all you have to do is to include it into your project's `build.gradle` file:

```gradle
dependencies {
        //other dependencies here...
        compile 'com.pddstudio:networkutils:x.y.z'
		//make sure you're always using the latest version of NetworkUtils
}
```

## Library Features Overview
Down below you can find a list of all current features the library comes with.

#### General Overview

- Simple Network Utilities (like getting the current IP-Address, and more...)
- ARP (Address Resolution Protocol) resolver and IP- / Mac-Address Mapper
- AdBlock detection (based on the phone's `host` file)
- Ping Utilities for checking local/remote address availability using Android's native ping binary
- Port Scanning Utilities for local/remote address scanning and open port detection (yet, supports TCP connections only)
- Discovery Utilities for DNS based service discovery on a local network over Multicast DNS (Avahi, Bonjour, ZeroConf)

#### NetworkUtils Javadoc

You can find the latest version of NetworkUtil's Javadoc [here](http://pddstudio.github.io/NetworkUtils/jdoc/)

## Installation

**Adding Permissions to your Application**

After adding the library as dependency to your project, continue by preparing your application and adding the required permissions to your `AndroidManifest.xml`: 

```xml
    <!-- This permission is required to perform network requests -->
    <uses-permission android:name="android.permission.INTERNET" />
    <!-- These permissions are required when using Utilities like retrieving the current IP-Address, ... --> 
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
```

Now you can start using NetworkUtils in two ways:

**1. Creating a Singleton instance**

Creating a Singleton instance allows you to only instantiate the Library once and access it's created instance from everywhere in your code.

To create the Singleton instance all you have to do is to call it's `initSingleton(Context context)` method before retrieving an instance. Therefore it's recommended to instantiate the Library in your Application's `onCreate(Bundle savedInstanceState)` method.

```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //other stuff in your onCreate method...

        NetworkUtils.initSingleton(this);
    }
```

Now you can retrieve the `NetworkUtils` Singleton from everywhere in your application's code by calling:

```java
    private void someNetworkMethod() {
        //retrieve the NetworkUtils Singleton
        NetworkUtils networkUtils = NetworkUtils.get();
        //now you can call any method in the library as usual
        Log.d("NetworkUtils", "Current IP-Address: " + networkUtils.getCurrentIpAddress());
    }
```

**2. Always retrieve a new instance**

In case you want to get a new instance of `NetworkUtils` everytime you want to operate with the library you can retrieve it by calling it's `get(Context context, Boolean flag)` method:
```java
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        //other stuff in your onCreate method...

        NetworkUtils networkUtils = NetworkUtils.get(this, true);
    }
```

That's it! Now you can continue with [synchronous](https://github.com/PDDStudio/NetworkUtils#synchronous-operations) or [asynchronous](https://github.com/PDDStudio/NetworkUtils#asynchronous-operations) requests.

##Synchronous Operations
Synchronous Operations are supposed to be called only on already existing background jobs, you won't be able to call a synchronous request in your application's UiThread.

##Asynchronous Operations
Asynchronous Operations are supposed to be called from your application's UiThread. The Library will execute your request(s) in the background and notify you about changes via the interface you provide. Asynchronous operations do always require a callback as parameter.

##ToDo List

- Add proper samples to the Readme instead of the sample application
- Implement Service which listens for network connection changes

##About & Contact
- In case you've a question feel free to hit me up via E-Mail (patrick.pddstudio@googlemail.com) 
- or [Google+](http://plus.google.com/+PatrickJung42)

##License
    Copyright 2016 Patrick J

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.