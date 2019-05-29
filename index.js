
import { NativeModules, Platform } from 'react-native';

const { RNKeepScreenOn } = NativeModules;


class KeepScreenOn  {

    static activate = (shouldDisplayOnLockScreen = false) => {
        RNKeepScreenOn.activate(shouldDisplayOnLockScreen)
    }

    static deactivate = () => {
        RNKeepScreenOn.deactivate()
    }

    static enableProximity = () => {
        if(Platform.OS === 'ios') return true; 
        return new Promise( (resolve, reject) => {
            RNKeepScreenOn.enableProximity( (succesful, data) => {
                if (succesful) 
                    resolve(succesful);
                else 
                    reject(data);
            })

        } )
    }

    static disableProximity = () => {
        if(Platform.OS === 'ios') return true; 
        return new Promise((resolve, reject) => {
            
            RNKeepScreenOn.disableProximity((succesful, data) => {
                if (succesful)
                    resolve(succesful);
                else
                    reject(data);
            })

        })
    }
}
export default KeepScreenOn;
