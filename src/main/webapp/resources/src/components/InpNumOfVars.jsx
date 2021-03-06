import React from 'react';

import './InpNumOfVars.less';

const InpNumOfVars = React.createClass({
    handleVarsChange() {
        this.props.onVarsChange(
            this.refs.selectNumOfX.value,
            this.refs.selectNumOfRestrictions.value
        );
    },
    render() {
        return (
            <div className="inp-num-of-vars">
                <div className="form-group">
                    <label className="control-label inp-num-of-vars__label">
                        <strong>Кількість змінних:</strong>
                    </label>
                    <select
                        value={this.props.numOfX}
                        className="form-control inp-num-of-vars__select select-num-x"
                        onChange={this.handleVarsChange}
                        ref="selectNumOfX"
                    >
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>
                <div className="form-group">
                    <label className="control-label inp-num-of-vars__label">
                        <strong>Кількість обмежень:</strong>
                    </label>
                    <select 
                        value={this.props.numOfRestrictions} 
                        className="form-control inp-num-of-vars__select select-num-restrictions"
                        onChange={this.handleVarsChange}
                        ref="selectNumOfRestrictions"
                    >
                        <option value="2">2</option>
                        <option value="3">3</option>
                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                    </select>
                </div>
            </div>
        );
    }
});
export default InpNumOfVars;
