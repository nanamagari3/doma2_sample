# doma2_sample
SpringBoot+Kotlin+doma2の雑魚サンプル

## 事前準備
1. DB準備する
テーブル:Users
カラム: id:Int、first_name:String、last_name:String

2. AppConfig直す

3. ./gradlew clean bootRunで起動

### 大雑把な使い方
アプリのURLはこれ。
http://localhost:8080/

* Usersテーブルのデータ一覧が見れます。
  * GET /users

* パラメータのidをキーとしてUsersテーブルを検索する。
  * GET /users/find?id=${id}

* Usersにレコードを追加。JSONを投げると登録処理が走ります。
  * POST /users/regist
 * リクエストJSONサンプル
{
    "id" : ${id},
    "firstName" : ${firstName},
    "lastName" : ${lastName}
}

* Usersのレコード更新。JSONを投げると更新処理が走ります。
  * POST /users/update
 * リクエストJSONサンプル
{
    "id" : ${id},
    "firstName" : ${firstName},
    "lastName" : ${lastName}
}

* Usersテーブルから、パラメータ:idと一致するレコードを削除。
  * GET /users/delete?id=${id}