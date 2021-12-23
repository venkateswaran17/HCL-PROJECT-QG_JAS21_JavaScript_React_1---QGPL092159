import React, { Component } from 'react'
import CustomerService from '../services/CustomerService';

class CreateCustomerComponent extends Component {
    constructor(props) {
        super(props)

        this.state = {
            // step 2
            id: this.props.match.params.id,
            firstName: '',
            lastName: '',
            age:'',
            gender:'',
            mobileNumber:'',
            email: ''
        }
        this.changeFirstNameHandler = this.changeFirstNameHandler.bind(this);
        this.changeLastNameHandler = this.changeLastNameHandler.bind(this);
        this.saveOrUpdateCustomer = this.saveOrUpdateCustomer.bind(this);
    }

   /// step 3
    componentDidMount(){

        // step 4
        if(this.state.id === '_add'){
            return
        }else{
            CustomerService.getCustomerById(this.state.id).then( (res) =>{
                let customer = res.data;
                this.setState({firstName: customer.firstName,
                    lastName: customer.lastName,
                    age: customer.age,
                    gender: customer.gender,
                    mobileNumber: customer.mobileNumber,
                    email : customer.email
                });
            });
        }        
    }
    saveOrUpdateCustomer = (e) => {
        e.preventDefault();
        let customer = {firstName: this.state.firstName, lastName: this.state.lastName, age: this.state.age,gender: this.state.gender,mobileNumber: this.state.mobileNumber, emailId: this.state.emailId};
        console.log('customer => ' + JSON.stringify(customer));

        // step 5
        if(this.state.id === '_add'){
            CustomerService.createCustomer(customer).then(res =>{
                this.props.history.push('/customer');
            });
        }else{
            CustomerService.updateCustomer(customer, this.state.id).then( res => {
                this.props.history.push('/customer');
            });
        }
    }
    
    changeFirstNameHandler= (event) => {
        this.setState({firstName: event.target.value});
    }

    changeLastNameHandler= (event) => {
        this.setState({lastName: event.target.value});
    }

   
    changeAgeHandler= (event) => {
        this.setState({age: event.target.value});
    }
        
    
        changeGenderHandler= (event) => {
            this.setState({gender: event.target.value});
        }
        changeMobileNumberHandler= (event) => {
            this.setState({mobileNumber: event.target.value});
        }
    
        changeEmailHandler= (event) => {
            this.setState({email: event.target.value});
        }
    
    cancel(){
        this.props.history.push('/customer');
    }

    getTitle(){
        if(this.state.id === '_add'){
            return <h3 className="text-center">Add Customer</h3>
        }else{
            return <h3 className="text-center">Add Customer</h3>
        }
    }
    
    render() {
        return (
            <div>
                <br></br>
                   <div className = "container">
                        <div className = "row">
                            <div className = "card col-md-6 offset-md-3 offset-md-3">
                                {
                                    this.getTitle()
                                }
                                <div className = "card-body">
                                    <form>
                                        <div className = "form-group">
                                            <label> First Name: </label>
                                            <input placeholder="First Name" name="firstName" className="form-control" 
                                                value={this.state.firstName} onChange={this.changeFirstNameHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label> Last Name: </label>
                                            <input placeholder="Last Name" name="lastName" className="form-control" 
                                                value={this.state.lastName} onChange={this.changeLastNameHandler}/>
                                        </div>
                                      
                                        <div className = "form-group">
                                            <label> Age: </label>
                                            <input placeholder="Your Age" name="age" className="form-control" 
                                                value={this.state.age} onChange={this.changeAgeHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label>  Gender: </label>
                                            <input placeholder="Gender" name="gender" className="form-control" 
                                                value={this.state.gender} onChange={this.changeGenderHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label>  MobileNumber: </label>
                                            <input placeholder="Mobile.No" name="mobileNumber" className="form-control" 
                                                value={this.state.mobileNumber} onChange={this.changeMobileNumberHandler}/>
                                        </div>
                                        <div className = "form-group">
                                            <label>  Email-ID: </label>
                                            <input placeholder="Email-Id" name="email" className="form-control" 
                                                value={this.state.email} onChange={this.changeEmailHandler}/>
                                        </div>
                                        <button className="btn btn-success" onClick={this.saveOrUpdateCustomer}>Save</button>
                                        <button className="btn btn-danger" onClick={this.cancel.bind(this)} style={{marginLeft: "10px"}}>Cancel</button>
                                    </form>
                                </div>  
                            </div>
                        </div>

                   </div>
            </div>
        )
    }
}

export default CreateCustomerComponent
