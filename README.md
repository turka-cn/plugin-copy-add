<h1 style="text-align: center">plugin-copy-add</h1>

<p style="text-align: center">
    <img src="https://shields.io/badge/Ver-1.0.2-59b7ff?style=flat" alt="version" />
    <img src="https://shields.io/badge/Halo-2.x+-59b7ff?style=flat" alt="halo" />
    <img src="https://shields.io/badge/License-MIT-green?style=flat" alt="license" />
</p>

适用于Halo2.x的复制追加插件，可在站点复制文本的时候自动追加一段内容，比如说版权提示

### 目前功能

支持三种分割模式：**空格、横线（---）和空行**

### 如何开发？

```bash
git clone https://github.com/turka-cn/plugin-copy-add

cd path/to/plugin-copy-add

./gradlew build

# Windows
./gradlew.bat build
```

别忘了修改 Halo 配置文件：

```yaml
halo:
  plugin:
    runtime-mode: development
    fixedPluginPath:
      - "/path/to/plugin-copy-add"
```

### 结尾

插件为业余时间开发，难免有些小小的问题和不足之处，所以也欢迎来提Issues或者帮忙交PR喔！

——（｡ò ∀ ó｡）