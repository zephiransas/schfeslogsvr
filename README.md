# schfeslogsvr

[@hideo54](https://github.com/hideo54)さん作の[scfeslog](https://github.com/hideo54/schfeslog)から送信されたスクフェスのプレイデータを受信するサーバです。

以下の機能があります。

## スクフェスプレイ結果受信機能
schfeslogから送信されたプレイデータを受信して保存します。

## スクフェスプレイ結果一覧機能
上記で受信したプレイ結果を一覧で見ることができます。

# 利用方法
1.当リポジトリをgit cloneします。

``` bash 
git clone git@github.com:zephiransas/schfeslogsvr.git
cd schfeslogsvr
```

2.デプロイするHerokuアプリを作成します。

```
heroku create
```

3.Herokuにデプロイします。

``` bash 
git push heroku master
```

4.schfeslogをgit cloneします。

※サーバ連携機能はまだ本家にマージされていません

``` bash
cd ~
git clone git@github.com:zephiransas/schfeslog.git
cd schfeslog
git checkout feature-log-server
```

5.settings.jsonを設定します。

settings.jsonに
``` json
"server": {
    "on": true,
    "uri": "https://[3でデプロイしたアプリのドメイン]/live/result"
}
```
を設定します。

6.schfeslogを起動します。

``` bash
node main.js
```

7.スマートフォンのプロキシを設定。
スマートフォンのWiFi設定からプロキシに
- サーバ - schfeslogを起動しているマシンのIP
- ポート - デフォルトのままなら25252ポート
を設定します。

8.スクフェスをプレイ！

スクフェスを通常どおりプレイして https://[3でデプロイしたアプリのドメイン] に結果が表示されれば、正しく送信できています。
