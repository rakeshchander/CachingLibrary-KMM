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
    url: "https://github.com/rakeshchander/CachingLibrary-KMM/releases/download/1.0.0/RCCachingManager.xcframework.zip",
    checksum: "a57d0ec8c1cbd123bd82d3b0ad93616d69a229c4bea8b75ccbf56a3f8524ee20"
        ),
    ]
)
