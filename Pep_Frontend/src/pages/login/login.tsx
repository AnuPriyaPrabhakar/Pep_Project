import React, { useEffect, useState } from "react";
import "./login.css";
import LoginApiService from "../../data/services/login/login_api_service";
import { FaEye, FaEyeSlash } from 'react-icons/fa';
import { saveLoginDetailsAction } from "./State/loginAction";
import { useDispatch } from "react-redux";
import { useNavigate } from "react-router-dom";
import { Snackbar } from "@mui/material";
import MuiAlert from '@mui/material/Alert';

const Login = () => {
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [usernameError, setUsernameError] = useState("");
  const [passwordError, setPasswordError] = useState("");
  const [loginStatus, setLoginStatus] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const [userFirstName, setUserFirstName] = useState("");
  const [isSuccessOpen, setIsSuccessOpen] = useState(false);
  const [successMessage, setSuccessMessage] = useState('');
  const [errorMessage, setErrorMessage] = useState('');
  const [isErrorOpen, setIsErrorOpen] = useState(false);

  const loginApiService = new LoginApiService();
  const dispatch = useDispatch();
  const navigate = useNavigate();
  useEffect(() => {
    if (sessionStorage.getItem('sessionTimedOut')) {
      sessionStorage.removeItem('sessionTimedOut'); // Clear the flag
      localStorage.removeItem('loginDetails');
      window.location.reload(); // Reload the page
    }
  }, []);
  const validateEmail = (email: string) => {
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return emailRegex.test(email);
  };

  const dispatchUserDetails = () => {
    const firstName = 'Hello Redux';
    const action = {
      type: 'SAVE_USER_DETAILS',
      payload: { firstName: firstName },
    };
    dispatch(action);
  }
  const showSuccessMessage = (message: string) => {
    setSuccessMessage(message);
    setIsSuccessOpen(true);
  };

  const showErrorMessage = (message: string) => {
    setErrorMessage(message);
    setIsErrorOpen(true);
  };

  const handleSubmit = async () => {
    setUsernameError("");
    setPasswordError("");
    if (username.trim() === "") {
      setUsernameError("Please enter your email");
    } else if (!validateEmail(username)) {
      setUsernameError("Please enter a valid email");
    }
    if (password.trim() === "") {
      setPasswordError("Please enter your password");
    }
    if (username.trim() !== "" && password.trim() !== "" && validateEmail(username)) {
      try {
        const loginResult = await loginApiService.login({ email: username, password });
        if (typeof loginResult === 'string') {
          setLoginStatus(loginResult);

        } else {
          try {
            const userId = loginResult.userId;
            setLoginStatus("Login successful!");
            // showSuccessMessage('Login added successfully.');
            const accessPermissionData = await loginApiService.accessPermission(userId);
            // console.log('Access Permission Data:', accessPermissionData);
            // console.log('Before Navigation - accessPermissionData:', accessPermissionData);
            // navigate('/header'); 
            // 
            navigate('/header', { state: { accessPermissionData } });
            dispatch(saveLoginDetailsAction(username, password, userId));
            // navigate('/dashboard', { state: { userFirstName } });
          } catch (error) {
            console.error("Error extracting userId:", error);
            setLoginStatus("An error occurred during login");
          }
        }
      } catch (error) {
        console.error("Error during login:", error);
        setLoginStatus("An error occurred during login");
      }
    }
  };

  const handleSubmitClick = () => {
    handleSubmit();
  }

  const handleKeyPress = (e: { key: string; }) => {
    if (e.key === 'Enter') {
      handleSubmit();
    }
  };
  //solu bro 
  // useEffect(() => {
  //   window.location.reload();
  // }, []);
  return (
    <div className="body-style">
      <div className="container-style login-container">
        <h2 className="login-head">Login</h2>
        <div className="form-groups">
          <label className="label-style">Email id :</label>
          <input
            type="text"
            className="form-control login-input"
            value={username}
            onChange={(e) => {
              setUsername(e.target.value);
              setUsernameError("");
            }}
          />
          <span className="error-message">{usernameError}</span>
        </div>
        <div className="form-groups">
          <label className="label-style">Password :</label>
          <div className="password-input">
            <input
              type={showPassword ? "text" : "password"}
              className="form-control login-input"
              value={password}
              onChange={(e) => {
                setPassword(e.target.value);
                setPasswordError("");
              }}
              onKeyPress={handleKeyPress}
            />
            <div className="eye-icon" onClick={() => setShowPassword(!showPassword)}>
              {showPassword ? <FaEyeSlash /> : <FaEye />}
            </div>
          </div>
          <span className="error-message">{passwordError}</span>
        </div>
        <button type="button" className="btn-submit login-button" onClick={handleSubmitClick}>
          Sign In
        </button>
        {loginStatus && (
          <div
            className={`alert ${loginStatus === 'Login successful!' ? 'alert-success' : 'alert-danger'}`}
            role="alert"
            style={{ marginTop: '10%' }}
          >
            {loginStatus}
          </div>
        )}
      </div>
      <Snackbar
        open={isSuccessOpen}
        autoHideDuration={5000}
        onClose={() => setIsSuccessOpen(false)}
        anchorOrigin={{
          vertical: 'top',
          horizontal: 'right',
        }}
      >
        <MuiAlert
          elevation={6}
          variant="filled"
          severity="success"
          onClose={() => setIsSuccessOpen(false)}
        >
          {successMessage}
        </MuiAlert>
      </Snackbar>
      <Snackbar
        open={isErrorOpen}
        autoHideDuration={5000}
        onClose={() => setIsErrorOpen(false)}
        anchorOrigin={{
          vertical: 'top',
          horizontal: 'right',
        }}
      >
        <MuiAlert
          elevation={6}
          variant="filled"
          severity="error"
          onClose={() => setIsErrorOpen(false)}
        >
          {errorMessage}
        </MuiAlert>
      </Snackbar>
      <Snackbar
        open={isErrorOpen}
        autoHideDuration={5000}
        onClose={() => setIsErrorOpen(false)}
        anchorOrigin={{
          vertical: 'top',
          horizontal: 'right',
        }}
      >
        <MuiAlert
          elevation={6}
          variant="filled"
          severity="error"
          onClose={() => setIsErrorOpen(false)}
        >
          {errorMessage}
        </MuiAlert>
      </Snackbar>

    </div>
  );
};

export default Login;

