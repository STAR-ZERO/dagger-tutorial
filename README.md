# Dagger tutorial

Daggerの基本的なことを書いたシンプルなアプリ群です。

各Stepに分かれていて、それぞれ独立して実行可能です。自分で色々試してみてください。

**指摘事項や質問があれば、Issueにお願いします**

## step1

Daggerを使ったシンプルなアプリです。

単純な`@Component`と`@Module`を定義してるだけです。

## step2

Scopeを使ったときにインスタンスがどう使われるかを試したアプリです。

`@Singleton`を使ったときにどうなるかを確認してみてください。

## step3

`@Component`の`dependencies`を使った、Componentの親子関係の定義です。

親と子それぞれでScopeを分けており、インスタンスの生存期間が異なります。

## step4

`@Subcomponent`を使った、Componentの親子関係の定義です。

step3では子Componentに親Componentを設定する感じでしたが、step4では親Componentから子Componentを取得する感じになります。

## step5

`@Component.Builder`を使ったサンプルです。

`@BindsInstance`を使った依存解決になります。Moduleのコンストラクタ引数を使うより、`@BindsInstance`を使うことが推奨されています。

## step6

`@Named`を使った、同じ型で違うインスタンスを依存解決する方法です。
