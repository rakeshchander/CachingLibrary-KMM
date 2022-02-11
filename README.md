
# Caching Manager - SDK

![](https://camo.githubusercontent.com/b1d9ad56ab51c4ad1417e9a5ad2a8fe63bcc4755e584ec7defef83755c23f923/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d616e64726f69642d3645444238442e7376673f7374796c653d666c6174) ![](https://camo.githubusercontent.com/1fec6f0d044c5e1d73656bfceed9a78fd4121b17e82a2705d2a47f6fd1f0e3e5/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d696f732d4344434443442e7376673f7374796c653d666c6174) ![](https://camo.githubusercontent.com/4ac08d7fb1bcb8ef26388cd2bf53b49626e1ab7cbda581162a946dd43e6a2726/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d74766f732d3830383038302e7376673f7374796c653d666c6174) ![](https://camo.githubusercontent.com/135dbadae40f9cabe7a3a040f9380fb485cff36c90909f3c1ae36b81c304426b/687474703a2f2f696d672e736869656c64732e696f2f62616467652f706c6174666f726d2d77617463686f732d4330433043302e7376673f7374796c653d666c6174) 

![](https://maven-badges.herokuapp.com/maven-central/io.github.rakeshchander/RCCachingManager/badge.svg) ![Carthage compatible](https://img.shields.io/badge/Carthage-compatible-4BC51D.svg?style=flat) ![](https://img.shields.io/badge/Swift_Package_Manager-compatible-orange?style=flat-square) ![](https://img.shields.io/cocoapods/v/RCCachingManager.svg)

![](https://github.com/rakeshchander/CachingLibrary-KMM/actions/workflows/main.yml/badge.svg)

### SAVE / READ Serialized Objects / Standard Data Types (String, Int, Data, Boolean, FLoat, Decimal, Array, Map) in User Preferences OR App Internal Storage

- **Supports KMM, iOS & Android apps**
  - Android version 26 & above
  - iOS version 12 & Above
  - Apple TvOS version 13 & Above
  - Apple WatchOS version 7 & Above



## Installation

##### KMM

Module level build.gradle

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.rakeshchander:RCCachingManager:<version>'
}
```
 

##### Android 
###### Kotlin 
App level build.gradle

```kotlin
repositories {
    mavenCentral()
}

dependencies {
    implementation 'io.github.rakeshchander:RCCachingManager:<version>'
}
```
###### JAVA 
App level build.gradle

```kotlin
plugins {
    id 'com.android.application'
    id 'org.jetbrains.kotlin.android'
}

android {
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

dependencies {
    implementation 'io.github.rakeshchander:RCCachingManager:<version>'
}
```
Project level build.gradle

```kotlin
plugins {
    id 'org.jetbrains.kotlin.android' version '1.5.30' apply false
}
```


##### iOS

###### CocoaPods 

[CocoaPods](https://cocoapods.org/) is a dependency manager for Cocoa projects. For usage and installation instructions, visit their website. To integrate Alamofire into your Xcode project using CocoaPods, specify it in your `Podfile`:

- Add below line in your podfile, if not there

  - ```
    source 'https://github.com/CocoaPods/Specs.git'
    ```

- Add below in podfile - in respective target block

```kotlin
pod 'RCCachingManager'
```

- Execute below command in terminal

  ```swift
  pod install --repo-update
  ```

###### Swift Package Manager - SPM

The [Swift Package Manager](https://swift.org/package-manager/) is a tool for automating the distribution of Swift code and is integrated into the `swift`compiler.

Once you have your Swift package set up, adding GrowthBook as a dependency is as easy as adding it to the `dependencies` value of your `Package.swift`.

```swift
dependencies: [
    .package(url: "https://github.com/rakeshchander/CachingLibrary-KMM.git")
]
```

###### Carthage (min Carthage version 0.38.0)

[Carthage](https://github.com/Carthage/Carthage) is a decentralized dependency manager that builds your dependencies and provides you with binary frameworks. To integrate Alamofire into your Xcode project using Carthage, specify it in your `Cartfile`:

```swift
binary "https://github.com/rakeshchander/CachingLibrary-KMM/blob/main/Carthage/RCCachingManager.json"
```

```swift
carthage update --use-xcframework
```



## Usage

#### Caching Manager - App Internal Storage
- You can save/ read String Data 
- You can save/ read Serailzable Class Objects

```kotlin
// Instantiate Caching Manager
val cachingLayer = RCCachingManager()

// Save String Content
cachingLayer.saveContent("AppMetaData", dataModel)
// Read String Content
val content = cachingLayer.getContent("AppMetaData")

// Save Serialzed Objects
cachingLayer.putSerializedData("AppMetaData", dataModel)
// Read Serialized Objects
val dataModel = cachingLayer.getSerializedData("AppMetaData")
```

#### Shared Preferences / User Defaults
- You can save/ read Supported Data types in Shared Prefrences / User Defaults

```kotlin
// Instantiate Preferences Manager
val prefLayer = RCUserPreferences()

// Save Content
prefLayer.setPrefValue("AppMetaData", dataModel)
// Read Content
val content = prefLayer.setPrefValue("AppMetaData")
```


## License

This project uses the Apache v2.0 license. The SDK will always remain open and free, although we may add some commercial enterprise add-ons in the future.