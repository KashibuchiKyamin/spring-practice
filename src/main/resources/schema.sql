-- Spring Security を使用した認証に使用する、ユーザ情報管理用のテーブルを作成します。
DROP TABLE IF EXISTS users;
CREATE TABLE users (
  email VARCHAR(255) PRIMARY KEY,    -- メールアドレスが主キー
  user_name VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
);