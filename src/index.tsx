import { NativeModules, Platform } from 'react-native';
import type { Spec } from './NativeShowcase';

const LINKING_ERROR =
  `The package 'react-native-showcase' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo Go\n';

// @ts-expect-error
const isTurboModuleEnabled = global.__turboModuleProxy != null;

const ShowcaseModule = isTurboModuleEnabled
  ? require('./NativeShowcase').default
  : NativeModules.Showcase;

const Showcase: Spec = ShowcaseModule
  ? ShowcaseModule
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export const {
  getOBject,
  getNumbers,
  callMeLater,
  promiseNumber,
  reverseString,
} = Showcase;
