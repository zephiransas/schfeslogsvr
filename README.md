# schfeslogsvr

[@hideo54](https://github.com/hideo54)さん作の[scfeslog](https://github.com/hideo54/schfeslog)から送信されたスクフェスのプレイデータを受信するサーバです。

以下の機能があります。

## スクフェスプレイ結果受信機能
schfeslogから送信されたプレイデータを受信して保存します。

## スクフェスプレイ結果一覧機能
上記で受信したプレイ結果を一覧で見ることができます。

# 利用方法

## サーバ側の準備

このボタンからサーバをHerokuにDeployできます。

[![Deploy](https://www.herokucdn.com/deploy/button.svg)](https://heroku.com/deploy?template=https://github.com/zephiransas/schfeslogsvr/tree/master)

deploy時にパスワードを設定してください。**ここで指定したパスワードはschfeslogで設定する必要があります。**

## schfeslogの準備

1.schfeslogをgit cloneします。

``` bash
cd ~
git clone git@github.com:hideo54/schfeslog.git
cd schfeslog
```

2.settings.jsonを設定します。

settings.jsonに
``` json
"server": {
  "on": true,
  "uri": "https://[Herokuにデプロイしたアプリのドメイン]/live/result",
  "password": "[Heroku Deploy時に設定したパスワード]"
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
