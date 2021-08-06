
import { NativeModules } from 'react-native';

const { RNAlipay } = NativeModules;


export async function onStartAlipay(alipay_normal) {
    return await RNAlipay.onStartAlipay(alipay_normal);
  }
// export default RNAlipay;
