Pod::Spec.new do |spec|
    spec.name                     = 'RCCachingManager'
    spec.version       = "0.1.0"
    spec.homepage                 = 'https://github.com/rakeshchander/CachingLibrary-KMM'
    spec.source       = { :https => "https://github.com/rakeshchander/CachingLibrary-KMM/releases/download/0.1.0/RCCachingManager.xcframework.zip"}
    spec.authors                  = 'rakeshchander.cse@gmail.com'
    spec.license                  = 'https://opensource.org/licenses/Apache-2.0'
    spec.summary                  = 'Caching Library for KMM, Android, iOS'

    spec.vendored_frameworks      = "XCFramework/RCCachingManager.xcframework"

    spec.ios.deployment_target = '12.0'
    spec.tvos.deployment_target = '13.0'
    spec.watchos.deployment_target = '7.0'

end
