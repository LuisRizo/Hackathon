import React, {Component} from 'react'
import {
	View,
	Text,
	Image,
	Modal,
	StyleSheet,
	TouchableOpacity,
} from 'react-native'

import FingerPrint from '../components/FingerPrint'

class FingerprintModal extends Component {
	render(){
		return(
			<Modal style={styles.BackgroundModal} visible={this.props.visible} onRequestClose={this.props.dismiss}>
				<TouchableOpacity style={{flex:1}} onPress={this.props.dismiss}>
					<View style={styles.MainModalContainer}>
						<Text>Please scan your fingerprint</Text>
						<Image source={require('../lib/images/fingerprint.png')} style={styles.Image}/>
					</View>
				</TouchableOpacity>
			</Modal>
		)
	}
}

const styles = StyleSheet.create({
	BackgroundModal:{
		flex:1,
		marginTop:20,
		backgroundColor:'rgba(0,0,0,0.3)',
		justifyContent:'center',
		alignItems:'center'
	},
	MainModalContainer: {
		backgroundColor:'white',
	},
	Image:{
		width:35,
		height:35,
		alignSelf:'center',
	}
})

export default FingerprintModal;