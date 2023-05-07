package cn.turka.copyadd.processor;

/**
 * 内容处理
 *
 * @author Turka
 * @date 2023/4/22 10:10
 */

public class ContentProcessor {

    public String scriptProcess(String copyAddContent, String divideType, String copyMinLength) {

        String processContent = switch (divideType) {
            case "line" -> "\\n---\\n" + copyAddContent;
            case "emptyLine" -> "\\n \\n" + copyAddContent;
            default -> " " + copyAddContent;
        };

        processContent = processContent.replaceAll("[\\t\\r\\n]", "\\\\n");

        return """
            <script>
                function contentParse(content) {
                    let parsed = content
                    
                    parsed = parsed.replaceAll("#url", window.location.href)
                    parsed = parsed.replaceAll("#site", window.location.host)
                    
                    return parsed
                }
                
                document.addEventListener("copy", (event) => {
                    let clipboard = event.clipboardData || window.clipboardData
                    let clipboardText = window.getSelection().toString()
                    
                    if (!clipboard || clipboardText.length <= %s) {
                        return
                    }
                    else if (clipboardText !== "") {
                        event.preventDefault()
                        clipboard.setData("text/plain", clipboardText + contentParse("%s"))
                    }
                })
            </script>
            """.formatted(copyMinLength, processContent);
    }
}
