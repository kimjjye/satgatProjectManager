import { useRef, useState } from "react";
import axiosInstance from "../config/axiosInstance";

function Login() {
  const [loginCheck, setLoginCheck] = useState(false);
  const [loginResultMessage, setLoginResultMessage] = useState("");
  const userId = useRef("");
  const password = useRef("");

  const handleLogin = async () => {
    axiosInstance
      .post("/login", { userId: userId.current, password: password.current })
      .then(() => {
        setLoginCheck(true);
        setLoginResultMessage("로그인 성공");
      })
      .catch((error) => {
        if (error.status === 401) {
          setLoginCheck(false);
          setLoginResultMessage("잘못된 아이디 혹은 비밀번호 입니다.");
        } else {
          alert(error.message);
        }
      });
  };

  return (
    <div>
      {!loginCheck && (
        <>
          <div>
            <div>
              <input
                id="userId"
                onChange={(e) => (userId.current = e.target.value)}
                type="text"
              ></input>
            </div>
            <div>
              <input
                id="password"
                onChange={(e) => (password.current = e.target.value)}
                type="password"
              ></input>
            </div>
          </div>
          <div>
            <button type="button" onClick={handleLogin}>
              로그인
            </button>
          </div>
        </>
      )}
      {loginResultMessage}
    </div>
  );
}

export default Login;
