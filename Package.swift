// swift-tools-version:5.4
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
    name: "RCCachingManager",
    platforms: [
        .iOS(.v12), .tvOS(.v13), .watchOS(.v7)
    ],
    products: [
        .library(
            name: "RCCachingManager",
            targets: ["RCCachingManager"]),
    ],
    dependencies: [
        // no dependencies
    ],
    targets: [
        .binaryTarget(
            name: "RCCachingManager",
    url: "https://github.com/rakeshchander/CachingLibrary-KMM/releases/download/0.1.0/RCCachingManager.xcframework.zip",
    checksum: "42a345a7dc57c3f44f99e429062f06d92c217d50f9681c60e4daf0bfacde8011"
        ),
    ]
)
