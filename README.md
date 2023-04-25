<h1 align="center">plugin-copy-add</h1>

<p align="center">
    <img src="https://shields.io/badge/Ver-1.0.2-59b7ff?style=for-the-badge" alt="version" />
    <img src="https://shields.io/badge/Halo-2.x+-59b7ff?style=for-the-badge" alt="halo" />
    <img src="https://shields.io/badge/License-MIT-green?style=for-the-badge" alt="license" />
</p>

适用于Halo2.x的复制追加插件，可在站点复制文本的时候自动追加一段内容，比如说版权提示

### 目前功能

支持三种分割模式：**空格、横线（---）和空行**

### 使用和设置方法

- Ⅰ、从`控制台`的插件页面里安装插件
- Ⅱ、点击插件名称进入`插件信息`
- Ⅲ、在插件信息内有个`附加设置`选项卡，点进去就能设置内容啦
- Ⅳ、**记得点`保存`，不然是不生效的！**

<img src="https://upload-cdn.turka.cn/turka-cn-data/1682340539465.png"/>

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