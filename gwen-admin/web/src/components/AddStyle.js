import * as React from 'react';

import { Form, Icon, Input, Button, InputNumber } from 'antd';

const FormItem = Form.Item;

@Form.create()
export default class AddStyle extends React.Component {

	constructor(props){
		super(props);
	}

  submit(){

  }

	render(){
		const { getFieldDecorator, getFieldsError, getFieldError, isFieldTouched} = this.props.form;
		return (
			<Form onSubmit={this.submit}>
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
			    		rules: [{required: true, message: '排序'}]
			    	})(
			    	  <InputNumber />
			    	)
			    }
			  </FormItem>
			</Form>
			);
	}
}