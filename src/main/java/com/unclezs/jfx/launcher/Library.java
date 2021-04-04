package com.unclezs.jfx.launcher;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 依赖文件
 *
 * @author blog.unclezs.com
 * @since 2021/03/23 13:46
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Library {

  private String path;
  private Long size;
  private Platform platform;

  public URL toUrl(Path libDir) {
    try {
      return libDir.resolve(path).toFile().toURI().toURL();
    } catch (MalformedURLException e) {
      throw new RuntimeException(e);
    }
  }


  public boolean currentPlatform() {
    return platform == null || platform == Platform.CURRENT;
  }
}
