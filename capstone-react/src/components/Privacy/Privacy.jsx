import React, { Fragment } from 'react';
import './Privacy.css'; //imports the styling for privacy page


function Privacy () {
    return (
            <section className="privacy">
                <section className="privacy-description">
                    <h1>Online Privacy Policy</h1><br />
                    When you visit or use our online services, we may collect personal 
                    information from you such as your name, email address, mailing address, 
                    telephone numbers, account numbers, limited locationinformation, user name 
                    and password. We may also collect social security numbers when you provide 
                    such information while using our website.<br/>
                    Keeping your account information updated is important. You may review, or 
                    update certain account information by logging in and accessing the 
                    “Update profile” section. If you cannot change the incorrect information 
                    online, or you prefer to request changes offline, please use the Contact Us 
                    option on our site, or call or write to us using the contact information 
                    listed on your account statements, records, or other account materials.
                </section>
            </section>
    )
}

export default Privacy;
