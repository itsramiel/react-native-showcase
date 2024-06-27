
#ifdef RCT_NEW_ARCH_ENABLED
#import "RNShowcaseSpec.h"

@interface Showcase : NSObject <NativeShowcaseSpec>
#else
#import <React/RCTBridgeModule.h>

@interface Showcase : NSObject <RCTBridgeModule>
#endif

@end
