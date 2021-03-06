/*
 * Copyright 2019 EMnify GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.emnify.akka.management.ui.site

import com.emnify.akka.management.ui.site.component.{AlertComponent, WebComponent}
import org.scalajs.dom.document
import scalatags.JsDom.all._
import scalatags.rx.all._

case class AkkaManagementErrorSite(error: String) extends Site {
  private val applicationContext = new AnyRef
    with WebComponent
    with AlertComponent

  override def render() = {
    import applicationContext.owner
    applicationContext.alert() = Some(error)
    document
      .getElementById("app")
      .appendChild(
        div(
          applicationContext.renderAlert,
          `class` := "mt-1 container"
        ).render
      )
  }
}
