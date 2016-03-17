import React from 'react';

import InitialDataForm from './InitialDataForm.jsx';
import ResMatrix from './ResMatrix.jsx';

import './MainBlock.less';

const MainBlock = React.createClass({
    handleFormSubmit: function(formData) {
        $.ajax({
            url: "/solveSimplex",
            dataType: 'json',
            type: 'POST',
            data: formData,
            success: function(data) {
                console.log("server response:", JSON.stringify(data));
                if(!data.error && data.matrix && data.notBasicVariables && data.basicVariables)
                    this.setState({resData: data});
                else if(data.error)
                    alert(data.error);
                else {
                    alert("invalid server response");
                    console.log("invalid server response:", data);
                }
            }.bind(this),
            error: function(xhr, status, err) {
                alert("Не вдалося відправити запит на сервер ;(");
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    getInitialState: function() {
        return {
            resData: {
                "basicVariables":["u1","u2","x1","x2","F"],
                "notBasicVariables":["u3","u4","x3","x4","B"],
                "matrix":[
                    [0.6, -1.83, 0, 0.5, 3],
                    [3.3, -1.6, 0, 15, 4],
                    [-3.3, 6.6, 0, 49.9, 5],
                    [3, 6, 1, 9, 2],
                    [3.3, 23.3, 0, 340, 8]
                ]
            }
        }
        ;
    },
    render() {
        return (
            <main className="container-fluid main-block">
                <div className="input-column">
                    <div className="input-block">
                        <InitialDataForm onFormSubmit={this.handleFormSubmit}/>
                    </div>
                </div>
                <div className="results-column">
                    <div className="results-block">
                        <ResMatrix resMatrixData={this.state.resData}/>
                    </div>
                </div>
            </main>
        );
    }
});

export default MainBlock;