import React from 'react';

import './Footer.less';

const Footer = React.createClass({
    render() {
        return (
            <footer>
                <div className="navbar navbar-default">
                    <p className="navbar-text text-center">
                        <a href="https://vk.com/max_genash" className="navbar-link">Генаш Максим</a>,
                        <a href="https://vk.com/id52117585" className="navbar-link">Шевченко Олександр</a>
                        &copy; 2016
                    </p>
                </div>
            </footer>
        );
    }
});

export default Footer;