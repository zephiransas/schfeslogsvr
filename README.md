# schfeslogsvr

[@hideo54](https://github.com/hideo54)さん作の[scfeslog](https://github.com/hideo54/schfeslog)から送信されたスクフェスのプレイデータを受信するサーバです。

以下の機能があります。

## スクフェスプレイ結果受信機能
schfeslogから送信されたプレイデータを受信して保存します。

## スクフェスプレイ結果一覧機能
上記で受信したプレイ結果を一覧で見ることができます。

# 利用方法

## サーバ側の準備

1.当リポジトリをgit cloneします。

``` bash 
git clone git@github.com:zephiransas/schfeslogsvr.git
cd schfeslogsvr
```

2.デプロイするHerokuアプリを作成します。

```
heroku create
heroku config:add TZ=Asia/Tokyo
```

3.データベースを追加します

``` bash
heroku addons:create heroku-postgresql:hobby-dev
```

4.Herokuにデプロイします。

``` bash 
git push heroku master
```

## schfeslogの準備

1.schfeslogをgit cloneします。

※サーバ連携機能はまだ本家にマージされていません

``` bash
cd ~
git clone git@github.com:zephiransas/schfeslog.git
cd schfeslog
git checkout feature-log-server
```

2.settings.jsonを設定します。

settings.jsonに
``` json
"server": {
    "on": true,
    "uri": "https://[herokuにデプロイしたアプリのドメイン]/live/result"
}
```
を設定します。

3.schfeslogを起動します。

``` bash
node main.js
```

4.スマートフォンのプロキシを設定。
スマートフォンのWiFi設定からプロキシに
- サーバ - schfeslogを起動しているマシンのIP
- ポート - デフォルトのままなら25252ポート
を設定します。

5.スクフェスをプレイ！

スクフェスを通常どおりプレイして https://[herokuにデプロイしたアプリのドメイン] で結果が表示されれば、正しく送信できています。
