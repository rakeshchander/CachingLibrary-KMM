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
    url: "https://github.com/rakeshchander/CachingLibrary-KMM/releases/download/1.1.0/RCCachingManager.xcframework.zip",
    checksum: "c8982f3e5e56adea5355396a68fb09c37f9223d09738ed1037c643b590e38573"
        ),
    ]
)
