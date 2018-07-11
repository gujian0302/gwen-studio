import * as React from 'react';
import { Form, Icon, Input, Button, InputNumber } from 'antd';

import styles from './style.less';
import { saveStyle } from '../services/style';

const FormItem = Form.Item;

@Form.create()
export default class AddStyle extends React.Component {

	constructor(props){
		super(props);
	}

  handleSubmit=(e)=>{
  	e.preventDefault();

  	this.props.form.validateFields((err, values)=>{
  		if(!err) {
  			saveStyle(values)
  			  .then(() => this.props.form.resetFields())
  			  .then(() => this.props.success());
  		}
  	})
  }

	render(){
		const { getFieldDecorator, getFieldsError, getFieldError, isFieldTouched} = this.props.form;
		return (
			<Form onSubmit={this.handleSubmit} className={styles.form}>
			  <FormItem>
			    {getFieldDecorator('name', {
			    	rules: [{required: true, message: '名称必须输入'}]
			    })(
			      <Input />
			    )}
			  </FormItem>

			  <FormItem>
			    {
			    	getFieldDecorator('ordinate', {
			    		rules: [{required: true, message: '排序必须输入'}]
			    	})(
			    	  <InputNumber />
			    	)
			    }
			  </FormItem>
			  <Button type="primary" htmlType="submit" onClick={this.handleSubmit} >保存</Button>
		</Form>
			);
	}
}

