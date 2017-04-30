import React, {Component} from 'react'
import {
	View,
	Text,
	Platform,
	StyleSheet,
	NativeModules,
	TouchableOpacity,
	DeviceEventEmitter
} from 'react-native'

import FingerprintModal from './FingerprintModal';

import { Button } from 'react-native-material-design';
import { THEME_NAME } from 'react-native-material-design';
import { PRIMARY_COLORS, COLOR } from 'react-native-material-design';

var TouchID = require('react-native-touch-id').default;

const {
	Fingerprint
} = NativeModules;



class FingerPrint extends Component {
	constructor(props){
		super(props);
		this.state={
			authenticated:false,
			authenticating:false,
		}
		this.dismiss = this.dismiss.bind(this);
	}

	componentWillMount(){
		DeviceEventEmitter.addListener('authStatus', this.onAuthStatus);
	}

	onAuthStatus = (eventBody) => {
		const authStatus = eventBody.authStatus;
		console.log("onAuthStatus", authStatus);
		this.setState({authenticated:authStatus});
	}

	onPress=()=>{
		console.log("NativeModules: ", NativeModules, Fingerprint);
		if (Platform.OS === "ios") {
			TouchID.authenticate(`Confirm it's you!`)
			.then(success => {
		    	console.log("Success", success);
		    	this.setState({
		    		authenticated: true,
		    		authenticating: false,
		    	});
		 	})
		  	.catch(error => {
		    	console.log("Error: ", error);
		    	this.setState({
		    		authenticated: false,
		    	});
	 	 	});
		}else{
			this.setState({authenticating:true});
			Fingerprint.authenticate();
		}
	}

	dismiss = () => {
		this.setState({authenticating:false});
	}


	render(){
		return(
			<View style={styles.ViewContainer}>
				<Button text="Scan finger" primary={PRIMARY_COLORS[0]} overrides={{backgroundColor:"#e74c3c"}} raised={true} onPress={()=>this.onPress()} />
				<FingerprintModal visible={this.state.authenticating} dismiss={this.dismiss} />
			</View>
		)
	}
}

const styles = StyleSheet.create({
	ViewContainer: {
		flex:1,
		backgroundColor: "#9b59b6", //Amethyst
		justifyContent:'center',
		alignItems: 'center',
	}
})

export default FingerPrint;