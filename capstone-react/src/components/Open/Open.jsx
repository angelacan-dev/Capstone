import React, {useState} from 'react';
import Button from '@material-ui/core/Button';
import Menu from '@material-ui/core/Menu';
import MenuItem from '@material-ui/core/MenuItem';

export default function Open() {
  const [anchorEl, setAnchorEl] = React.useState(null);

  const [buttonLabel, setButtonLabel] = useState("Type of Account");

  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };

  const handleClose = (event, index) => {
      console.log(index);
      setButtonLabel(index);
    setAnchorEl(null);
  };



  return (
    <div>
      <Button aria-controls="simple-menu" aria-haspopup="true" onClick={handleClick}>
        {buttonLabel}
      </Button>
      <Menu
        id="simple-menu"
        anchorEl={anchorEl}
        keepMounted
        open={Boolean(anchorEl)}
        onClose={handleClose}
      >
        <MenuItem onClick={(event)=>handleClose(event, "Personal Checking")}>Personal Checking</MenuItem>
        <MenuItem onClick={(event)=>handleClose(event, "Personal Savings")}>Personal Savings</MenuItem>
        <MenuItem onClick={(event)=>handleClose(event, "Business Checking")}>Business Checking</MenuItem>
        <MenuItem onClick={(event)=>handleClose(event, "IRA")}>IRA</MenuItem>
        <MenuItem onClick={(event)=>handleClose(event, "CD")}>CD</MenuItem>
      </Menu>
    </div>
  );
}