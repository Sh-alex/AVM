import React from 'react';

import InpNumOfVars from './InpNumOfVars.jsx';
import InpMatrix from './InpMatrix.jsx';
import OptFunc from './OptFunc.jsx';

import './InitialDataForm.less';

const InitialDataForm = React.createClass({
    getInitialState() {
        return {
            numOfX: 2,
            numOfRestrictions: 3
        };
    },
    handleNumOfVarsChange(numOfX, numOfRestrictions) {
        this.setState({ numOfX, numOfRestrictions });
    },
    readFormData() {
        let optFuncBlock = $(".opt-func"),
            inpMatrixBlock = $(".inp-matrix");
        let C = optFuncBlock.find(".inp-cell__input").map((i, el) => $(el).val()).toArray();
        let B = [];/* = $(".inp-matrix")
            .find(".inp-matrix__cell-B")
            .find(".inp-cell__input")
            .map((i, el) => $(el).val());   */
        let A = [];
        let inequalityTypes = [];
        inpMatrixBlock.find(".inp-matrix__row").each((i, row) => {
            let A_row = $(row).find(".inp-matrix__cell-A")
                .map((i, el) => $(el).find(".inp-cell__input").val())
                .toArray();
            A.push(A_row);
            let B_el = $(row).find(".inp-matrix__cell-B")
                .find(".inp-cell__input")
                .val();
            B.push(B_el);
            let inequalityType = $(row).find(".inp-matrix__select--inequality-type").val();
            inequalityTypes.push(inequalityType);
        });
        let optCriterion = optFuncBlock.find(".opt-func__select-criterion").val();
        let result = {
            A,
            B,
            C,
            optCriterion,
            inequalityTypes
        };
        console.log("FormData:", JSON.stringify(result) );
        return result;
    },
    handleSubmit(e){
        e.preventDefault();
        let formData = this.readFormData();
        console.log(JSON.stringify(formData));
        //передаємо зчитані дані в батьківський компонент щоб він відправив запит на сервер і змінив свій стан
        this.props.onFormSubmit(formData);
    },
    render() {
        return (
            <form className="initial-data-form" onSubmit={this.handleSubmit}>
                <InpNumOfVars
                    numOfX = {this.state.numOfX}
                    numOfRestrictions = {this.state.numOfRestrictions}
                    onVarsChange = {this.handleNumOfVarsChange}
                />
                <InpMatrix
                    numOfX = {this.state.numOfX}
                    numOfRestrictions = {this.state.numOfRestrictions}
                />
                <OptFunc
                    numOfX = {this.state.numOfX}
                />
                <div className="form-group text-center">
                    <button type="submit" className="btn btn-primary">Порахувати</button>
                </div>
            </form>
        );
    }
});

export default InitialDataForm;
