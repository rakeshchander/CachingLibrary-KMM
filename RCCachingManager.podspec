Pod::Spec.new do |spec|
    spec.name                     = 'RCCachingManager'
    spec.version       = "1.0.0"
    spec.homepage                 = 'https://github.com/rakeshchander/CachingLibrary-KMM'
    spec.source       = { :git => "https://github.com/rakeshchander/CachingLibrary-KMM/releases/download/1.0.0/RCCachingManager.xcframework.zip"}
    spec.authors                  = 'rakeshchander.cse@gmail.com'
    spec.license                  = 'https://opensource.org/licenses/Apache-2.0'
    spec.summary                  = 'Caching Library for KMM, Android, iOS'

    spec.vendored_frameworks      = "RCCachingManager.xcframework"

    spec.ios.deployment_target = '12.0'

end
