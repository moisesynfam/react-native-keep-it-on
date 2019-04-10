
import { NativeModules } from 'react-native';

const { RNKeepScreenOn } = NativeModules;


class KeepScreenOn  {

    static activate = (shouldDisplayOnLockScreen = false) => {
        RNKeepScreenOn.activate(shouldDisplayOnLockScreen)
    }

    static deactivate = () => {
        RNKeepScreenOn.deactivate()
    }
}
export default KeepScreenOn;
