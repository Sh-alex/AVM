import React from 'react';

import './Header.less';

const Header = React.createClass({
    render() {
        return (
            <header className="navbar navbar-default navbar-static-top">
                <div className="container-fluid">
                    <h1 className="text-center"> Лабораторна робота з ГКС4 №1 </h1>
                </div>
            </header>
        );
    }
});

export default Header;