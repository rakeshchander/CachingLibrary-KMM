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
    url: "https://github.com/rakeshchander/CachingLibrary-KMM/releases/download/0.1.2/RCCachingManager.xcframework.zip",
    checksum: "fa55babd7f2481bfd215b46a16cd1e846e573955e9309e5d32f8f2089af12201"
        ),
    ]
)
