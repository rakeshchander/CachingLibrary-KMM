Pod::Spec.new do |spec|
    spec.name                     = 'RCCachingManager'
    spec.version       = "0.1.2"
    spec.homepage                 = 'https://github.com/rakeshchander/CachingLibrary-KMM'
    spec.source       = { :http => "https://github.com/rakeshchander/CachingLibrary-KMM/releases/download/0.1.2/RCCachingManager.xcframework.zip"}
    spec.authors                  = 'rakeshchander.cse@gmail.com'
    spec.license                  = 'https://opensource.org/licenses/Apache-2.0'
    spec.summary                  = 'Caching Library for KMM, Android, iOS'

    spec.vendored_frameworks      = "RCCachingManager.xcframework"

    spec.ios.deployment_target = '12.0'

end
