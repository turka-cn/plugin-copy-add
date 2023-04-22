package cn.turka.copyadd.processor;

/**
 * 内容处理
 *
 * @author Turka
 * @date 2023/4/22 10:10
 */

public class ContentProcessor {

    public String springProcess(String copyAddContent, String divideType) {

        String processContent = switch (divideType) {
            case "line" -> "\\n---\\n" + copyAddContent;
            case "emptyLine" -> "\\n \\n" + copyAddContent;
            default -> " " + copyAddContent;
        };

        processContent = processContent.replaceAll("[\\t\\r\\n]", "\\\\n");

        return """
            <script>
                document.addEventListener("copy", (event) => {
                    let clipboard = event.clipboardData || window.clipboardData
                    let clipboardText = window.getSelection().toString()
                    
                    if (!clipboard) {
                        return
                    }
                    else if (clipboardText !== "") {
                        event.preventDefault()
                        clipboard.setData("text/plain", clipboardText + "%s")
                    }
                });
            </script>
            """.formatted(processContent);
    }
}
